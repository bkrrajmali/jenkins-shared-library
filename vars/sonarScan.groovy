def call(Map args = [:]) {
    def sonarArgs = args.get('params', '')

    log("Starting SonarQube analysis")

    withCredentials([string(credentialsId: 'sonar-token', variable: 'SONAR_TOKEN')]) {
        withSonarQubeEnv('SonarQubeServer') {
            sh "mvn sonar:sonar -Dsonar.login=$SONAR_TOKEN ${sonarArgs}"
        }
    }
}
