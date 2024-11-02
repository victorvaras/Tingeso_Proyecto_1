pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage("Build Backend and Push Docker image") {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/victorvaras/Tingeso_Proyecto_1.git']])
                dir("Backend") {
                    bat "mvn clean install"
                    bat "docker build -t victorvaraspro/tingeso-frontend:latest ."
                    bat "docker push victorvaraspro/tingeso-frontend:latest"
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
                    bat "docker build -t victorvaraspro/tingeso-frontend:latest ."
                    bat "docker push victorvaraspro/tingeso-frontend:latest"
                }
            }
        }
    }
}