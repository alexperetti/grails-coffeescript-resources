#CoffeeScript Resource plugin#
This plugin integrates <a href="http://jashkenas.github.com/coffee-script/">CoffeeScript</a> with the grails resources plugin.

<a href="https://github.com/yeungda/jcoffeescript">JCoffeeScript</a> is the java library used to compile to CoffeeScript version 1.1.


##Installation##
<pre><code>grails install-plugin coffeescript-resources</code></pre>

##Usage##
<pre><code>'js' {
        resource url:'coffee/test.coffee',attrs:[rel: "script/javascript", type:'js'], bundle:'bundle_coffee'
        resource url:'js/main.js'
    }
</code></pre>

###Required Settings for CoffeeScript###
<ul>
<li><b>url</b>: The location of the .coffee file</li>
<li><b>attrs[rel]</b>: should be set to script/javascript for compatibility reasons</li>
<li><b>attrs[type]</b>: must be set to "js" for resources to process</li>
<li><b>bundle</b>: Must be set as will not default correctly because of attrs usage. To add to default bundle use 'bundle_<module name>'</li>
</ul>

See the <a href="http://www.grails.org/plugin/resources">Resources plugin</a> for more details on available configurations

##Issues##
<ul>
    <li>Must specify the default bundle manually as this is calculated based on file extension by default.</li>
    <li>When debug is switched on there is currently no way to fall back to compiled coffeescript. The coffee files will be rendered unprocessed</li>
</ul>

##Special Thanks##
This plugin is heavily influenced by the work of Paul Fairless who created the <a href="http://grails.org/plugin/lesscss-resources">lesscss-resources</a> plugin.