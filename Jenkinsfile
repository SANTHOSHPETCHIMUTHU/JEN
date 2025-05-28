pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Compiling source...'
                sh 'mkdir -p out'
                sh 'javac -d out src/org/example/App.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'javac -cp .:junit.jar -d out src/org/example/AppTest.java'
                sh 'java -cp .:junit.jar:out org.junit.runner.JUnitCore org.example.AppTest'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging JAR...'
                sh 'jar cf app.jar -C out .'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying artifact...'
                sh 'mkdir -p deploy'
                sh 'cp app.jar deploy/'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
