def call(String imageName) {
    echo "[Trivy Scan] Scanning image: ${imageName}"
    
    sh """
        trivy image --format table --severity CRITICAL,HIGH,MEDIUM --ignore-unfixed ${imageName} | tee trivy-report.txt
    """
    
    // Optionally archive the scan report
    archiveArtifacts artifacts: 'trivy-report.txt', allowEmptyArchive: true
}
