def call(String imageNameWithTag) {
    log("Installing Trivy")
    sh 'chmod +x ./jenkins-shared-library/resources/scripts/trivy-install.sh'
    sh './jenkins-shared-library/resources/scripts/trivy-install.sh'

    log("Scanning image with Trivy")
    sh "trivy image --exit-code 1 --severity HIGH,CRITICAL ${imageNameWithTag}"
}
