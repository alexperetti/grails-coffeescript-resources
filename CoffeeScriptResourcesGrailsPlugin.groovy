class CoffeeScriptResourcesGrailsPlugin {
    // the plugin version
    def version = "0.4"
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "2.0.0 > *"
    // the other plugins this plugin depends on
    def dependsOn = [resources:'1.0 > *']
    def loadAfter = ['resources']
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/*.gsp",
            "web-app/coffee/*"
    ]

    def author = "Alex Peretti"
    def authorEmail = "alex@alexperetti.com"
    def title = "CoffeeScript Resources"
    def description = '''\\
Compile CoffeeScript to JS server-side via grails resources plugin.
'''

    // URL to the plugin's documentation
    def documentation = "https://github.com/alexperetti/grails-coffeescript-resources"
}
