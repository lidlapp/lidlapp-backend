pipeline {
    agent {
        docker {
            image 'maven:3-jdk-10'
            args '-v $HOME/.m2:/root/.m2 -v /var/lidlapp-backend:/var/lidlapp-backend'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean install'
            }
        }
        stage('Test') {
            post {
                always {
                    junit '**/target/surefire-reports/*.xml'

                }

            }
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            agent none
            steps {
                sh './deploy.sh'
            }
        }
    }
}