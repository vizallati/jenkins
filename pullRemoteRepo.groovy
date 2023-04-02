
pipeline {
    agent any

    parameters {
        string(name: 'GIT_URL', defaultValue: 'https://github.com/vizallati/allati.git', description: 'URL of the Git repository to clone')
        string(name: 'GIT_BRANCH', defaultValue: 'main', description: 'Branch of the Git repository to clone')
        string(name: 'TARGET_DIR', defaultValue: '/home/webfiles', description: 'Target directory to clone the Git repository to')
        string(name: 'HOSTING_DIR', defaultValue: '/home/allati/Repositories', description: 'Directory to move clone repository')
    }

    stages {
        stage('Clone Repository') {
            steps {
                dir(TARGET_DIR) {
                    git branch: GIT_BRANCH, url: GIT_URL
                }
            }
        }
        stage('Move Cloned Repository') {
            steps {
                sh "sudo mv ${TARGET_DIR} ${HOSTING_DIR}"
                echo "File was successfully moved"
            }
        }
    }
}
