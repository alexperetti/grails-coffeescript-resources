import org.jcoffeescript.JCoffeeScriptCompiler
import org.jcoffeescript.JCoffeeScriptCompileException
import org.grails.plugin.resource.mapper.MapperPhase

import org.codehaus.groovy.grails.plugins.support.aware.GrailsApplicationAware
import org.codehaus.groovy.grails.commons.GrailsApplication

/**
 * @author Alex Peretti
 *
 * Mapping file to compile .coffee files into .js files
 */
class CoffeeScriptResourceMapper implements GrailsApplicationAware {

    GrailsApplication grailsApplication

    def phase = MapperPhase.GENERATION // need to run early so that we don't miss out on all the good stuff

    static defaultExcludes = ['**/*.css','**/*.png','**/*.gif','**/*.jpg','**/*.jpeg','**/*.gz','**/*.zip']
    static String COFFEE_FILE_EXTENSION = '.coffee'

    def map(resource, config){
        File originalFile = resource.processedFile
        File target

        if (originalFile.name.toLowerCase().endsWith(COFFEE_FILE_EXTENSION)) {
            File input = originalFile
            target = new File(generateCompiledFileFromOriginal(originalFile.absolutePath))

            if (log.debugEnabled) {
                log.debug "Compiling CoffeeScript file [${originalFile}] into [${target}]"
            }
            try {
				// make coffee
				String javascript = new JCoffeeScriptCompiler().compile( originalFile.getText() )
				target.write(javascript)

                resource.processedFile = target

                resource.sourceUrlExtension = 'js'
                resource.actualUrl = generateCompiledFileFromOriginal(resource.originalUrl)
                resource.contentType = 'text/javascript'
                resource.tagAttributes.rel = 'script'
            } catch (JCoffeeScriptCompileException e) {
                log.error("error compiling coffee file: ${originalFile}")
                e.printStackTrace()
            }
        }
    }

    private String generateCompiledFileFromOriginal(String original) {
         original.replaceAll(/(?i)\.coffee/, '_coffee.js')
    }

    private File getOriginalFileSystemFile(String sourcePath) {
        grailsApplication.parentContext.getResource(sourcePath).file
    }

}
