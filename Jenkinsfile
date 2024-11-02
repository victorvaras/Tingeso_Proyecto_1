pipeline {
    agent any
    tools {
        maven "maven"
    }
    environment {
            DOCKER_CREDENTIALS_ID = 'dockerhub_credentials' // ID que configuraste en Jenkins
        }

    stages {
        stage("Build Backend and Push Docker image") {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/victorvaras/Tingeso_Proyecto_1.git']])
                dir("Backend") {
                    bat "mvn clean install"
                    script {
                        docker.withRegistry('', DOCKER_CREDENTIALS_ID) {
                        bat "docker build -t victorvaraspro/tingeso-backend:latest ."
                        bat "docker push victorvaraspro/tingeso-backend:latest"
                        }
                    }
                }
            }
        }

        stage("Test") {
            steps {
                dir("Backend") {
                    bat "mvn test"
                }
            }
        }
        stage("Build and Push Docker Image") {
            steps {
                dir("gestion-estudiantes-backend") {
                    script {
                        withDockerRegistry(credentialsId: 'docker-credentials') {
                            bat "docker build -t polloh/gestion-estudiantes-backend ."
                            bat "docker push polloh/gestion-estudiantes-backend"
                        }
                    }
                }
            }
        }

        stage("Build Frontend and push docker image") {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/victorvaras/Tingeso_Proyecto_1.git']])
                dir("Frontend") {
                    bat "npm install"
                    bat "npm run build"
                    script {
                        docker.withRegistry('', DOCKER_CREDENTIALS_ID) {
                        bat "docker build -t victorvaraspro/tingeso-frontend:latest ."
                        bat "docker login -u victorvaraspro"
                        bat DOCKER_CREDENTIALS_ID
                        bat "docker push victorvaraspro/tingeso-frontend:latest"
                        }
                    }
                }
            }
        }
    }
}