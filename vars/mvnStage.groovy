def call(String phase) {
    log("Running Maven Phase: ${phase}")
    sh "mvn ${phase}"
}
