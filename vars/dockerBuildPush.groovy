// def call(String imageName, String tag) {
//     log("Building Docker image: ${imageName}:${tag}")
//     sh "docker build -t ${imageName}:${tag} ."

//     log("Pushing Docker image to registry")
//     withCredentials([usernamePassword(credentialsId: 'docker-cred', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
//         sh "echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin"
//         sh "docker push ${imageName}:${tag}"
//     }
// }

def call(String imageName, String imageTag, String acrLoginServer, String acrUsername, String acrPasswordId) {
    withCredentials([usernamePassword(credentialsId: acrPasswordId, usernameVariable: 'ACR_USER', passwordVariable: 'ACR_PASS')]) {
        sh """
            echo "[LOG] Logging into Azure Container Registry..."
            echo \$ACR_PASS | docker login ${acrLoginServer} -u \$ACR_USER --password-stdin

            echo "[LOG] Building Docker image..."
            docker build -t ${acrLoginServer}/${imageName}:${imageTag} .

            echo "[LOG] Pushing image to ACR..."
            docker push ${acrLoginServer}/${imageName}:${imageTag}

            echo "[LOG] Docker image pushed: ${acrLoginServer}/${imageName}:${imageTag}"
        """
    }
}
