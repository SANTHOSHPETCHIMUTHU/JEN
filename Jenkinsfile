pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Compiling Java source...'
                bat 'javac -d out src\\org\\example\\App.java'
            }
        }

        stage('Test') {
            steps {
                echo 'Running JUnit tests...'
                bat 'javac -cp "libs\\junit-4.13.2.jar;libs\\hamcrest-core-1.3.jar;out" -d out src\\org\\example\\AppTest.java'
                bat 'java -cp "libs\\junit-4.13.2.jar;libs\\hamcrest-core-1.3.jar;out" org.junit.runner.JUnitCore org.example.AppTest'
            }
        }

        stage('Package') {
            steps {
                echo 'Creating JAR file...'
                bat 'jar cf app.jar -C out .'
            }
        }

        stage('Deploy') {
            steps {
                echo 'Copying JAR to deploy folder...'
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
