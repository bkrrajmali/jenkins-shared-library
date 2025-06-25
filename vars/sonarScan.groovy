def call(Map config) {
    withSonarQubeEnv('SonarQubeServer') {
        sh """
            mvn sonar:sonar \
                -Dsonar.organization=${config.organization} \
                -Dsonar.projectKey=${config.projectKey} \
                -Dsonar.projectName=${config.projectName} \
                -Dsonar.java.binaries=. \
                -Dsonar.exclusions=${config.exclusions}
        """
    }
}
