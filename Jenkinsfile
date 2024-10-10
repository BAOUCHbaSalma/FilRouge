pipeline {
    agent any

    environment {
        DOCKERHUB_CREDENTIALS = credentials('docker-hub-credentials')
        SONARQUBE_TOKEN = 'squ_f6291688a2b6b46dba09903e0bb6b5490c3f7cd5'
        SONARQUBE_SERVER = 'http://localhost:9000'
         DOCKERHUB_USERNAME = 'salmaba'
         DOCKERHUB_PASSWORD ='dckr_pat_tzfk94fhfU1ws0xQ9FJWTHY3SLM'
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
                bat 'mvn clean package'
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

        stage('Build and Push Docker Images') {
            parallel {
                stage('Build Docker & Push for doowaste') {
                    steps {
                        script {
                            def dockerImage = docker.build("salmaba/doowaste:${env.TAG_VERSION ?: 'latest'}")
                            docker.withRegistry('https://index.docker.io/v1/', ${DOCKERHUB_USERNAME}:${DOCKERHUB_PASSWORD}) {
                                dockerImage.push()
                            }
                        }
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
}
