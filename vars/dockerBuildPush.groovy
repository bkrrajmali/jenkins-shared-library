def call(String imageName, String tag) {
    log("Building Docker image: ${imageName}:${tag}")
    sh "docker build -t ${imageName}:${tag} ."

    log("Pushing Docker image to registry")
    withCredentials([usernamePassword(credentialsId: 'docker-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
        sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
        sh "docker push ${imageName}:${tag}"
    }
}
