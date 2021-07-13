pipelineJob('job-dsl-plugin') {
  definition {
    cpsScm {
      scm {
        git {
          remote {
            url('https://github.com/cdboyyyy/docker-cicd.git')
          }
          branch('*/advanced')
        }
        scriptPath('./apps/app2/')
      }
      lightweight()
    }
  }
}