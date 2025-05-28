pipeline {
    agent any

    environment {
        JUNIT_JAR = 'libs\\junit-4.13.2.jar'
        HAMCREST_JAR = 'libs\\hamcrest-core-1.3.jar'
    }

    stages {
        stage('Build') {
            steps {
                echo 'Compiling source...'
                bat 'mkdir out'
                bat 'javac -d out src\\org\\example\\App.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Running tests...'
                bat 'mkdir out'
                bat 'javac -cp .;%JUNIT_JAR%;%HAMCREST_JAR% -d out src\\org\\example\\AppTest.java'
                bat 'java -cp out;%JUNIT_JAR%;%HAMCREST_JAR% org.junit.runner.JUnitCore org.example.AppTest'
            }
        }

        stage('Package') {
            steps {
                echo 'Packaging JAR...'
                bat 'jar cf app.jar -C out .'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying artifact...'
                bat 'mkdir deploy'
                bat 'copy app.jar deploy\\'
            }
        }
    }

    post {
        success {
            echo '✅ Pipeline completed successfully.'
        }
        failure {
            echo '❌ Pipeline failed.'
        }
    }
}
