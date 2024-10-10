pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-credentials')
        SONARQUBE_TOKEN = 'squ_f6291688a2b6b46dba09903e0bb6b5490c3f7cd5'
        SONARQUBE_SERVER = 'http://localhost:9000'
    }

    tools {
        maven 'mvn'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/BAOUCHbaSalma/FilRouge.git'
            }
        }

        stage('Build and Test') {
            steps {
                bat 'mvn clean install'
                bat 'mvn test'
            }
        }

        stage('SonarQube Analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarQubeScanner'
                    bat "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=doowaste -Dsonar.sources=. -Dsonar.host.url=${SONARQUBE_SERVER} -Dsonar.login=${SONARQUBE_TOKEN} -Dsonar.java.binaries=target/classes"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // Lister les fichiers avant la construction
                    bat 'dir' // Pour Windows
                    bat 'mvn clean package' // Assurez-vous que le JAR est construit

                    def dockerImage = docker.build("salmaba/doowaste:${env.TAG_VERSION ?: 'latest'}")
                    bat 'docker images' // Afficher les images après la construction

                    // Vérifiez si l'image a été construite
                    if (dockerImage) {
                        echo "Image Docker construite avec succès."
                    } else {
                        error "Échec de la construction de l'image Docker."
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', DOCKERHUB_CREDENTIALS) {
                        def dockerImage = "salmaba/doowaste:${env.TAG_VERSION ?: 'latest'}"
                        echo "Pousser l'image Docker ${dockerImage} vers Docker Hub."
                        docker.image(dockerImage).push()
                    }
                }
            }
        }

        stage('Deploy with Docker Compose') {
            steps {
                bat 'docker-compose up -d'
            }
        }
    }

    post {
        success {
            echo "Pipeline exécuté avec succès !"
        }
        failure {
            echo "Échec du pipeline, vérifiez les logs."
        }
        always {
            cleanWs() // Nettoyer l'espace de travail
        }
    }
}
