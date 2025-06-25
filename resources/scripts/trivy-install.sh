#!/bin/bash
set -e
if ! command -v trivy &> /dev/null; then
  echo "Installing Trivy..."
  curl -sfL https://raw.githubusercontent.com/aquasecurity/trivy/main/contrib/install.sh | sh -s -- -b /usr/local/bin
else
  echo "Trivy already installed."
fi
