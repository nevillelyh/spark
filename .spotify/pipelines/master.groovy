@Grab(group='com.spotify', module='pipeline-conventions', version='0.0.5-SNAPSHOT', changing=true)

/**
 * This pipeline builds and uploads stable packages only
 * Set VERSION and EPOCH to fit your project.
 */

import com.spotify.pipeline.*

def RELEASE = 'stable'
def VERSION = '1.0.0'
def EPOCH   = '1'

use(Pipeline, dist.Deb, deploy.Deploy) {
    pipeline {
        stage('Build') {
            version("${EPOCH}:${VERSION}")
            buildPackage(distro: RELEASE)
            uploadPackage(distro: RELEASE)
        }
    }
}
