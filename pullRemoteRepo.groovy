pipeline {
    agent any

    parameters {
        string(name: 'GIT_URL', defaultValue: 'https://github.com/vizallati/allati.git', description: 'URL of the Git repository to clone')
        string(name: 'GIT_BRANCH', defaultValue: 'main', description: 'Branch of the Git repository to clone')
        string(name: 'TARGET_DIR', defaultValue: 'C:/Users/iekwo/Desktop/Github/allati', description: 'Target directory to clone the Git repository to')
    }

    stages {
        stage('Clone Repository') {
            steps {
                dir(TARGET_DIR) {
                    git branch: GIT_BRANCH, url: GIT_URL
                }
            }
        }
    }
}
