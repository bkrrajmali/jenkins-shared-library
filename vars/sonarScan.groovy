def call() {
    log("Starting SonarQube analysis")
    withSonarQubeEnv('SonarQubeServer') {
        sh "mvn sonar:sonar"
    }
}
