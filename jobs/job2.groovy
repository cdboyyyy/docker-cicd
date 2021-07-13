job('NodeJS Docker example') {
    scm {
        git('https://github.com/cdboyyyy/docker-cicd.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL cdboyyyy')
            node / gitConfigEmail('cdboyyyy@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('cdboyyyy/course/test')
            tag('${GIT_REVISION,length=9}')
            registryCredentials('34a5d27b-a837-4dd4-a52f-bc3d6748f58c')
            forcePull(false)
            forceTag(false)
            createFingerprints(false)
            skipDecorate()
            buildContext('./apps/app1/Dockerfile')
        }
    }
}
