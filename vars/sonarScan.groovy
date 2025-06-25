def call(Map args = [:]) {
    log("Starting SonarQube analysis")

    def sonarArgs = args.get('params', '')

    withSonarQubeEnv('SonarQubeServer') {
        sh "mvn sonar:sonar ${sonarArgs}"
    }
}
