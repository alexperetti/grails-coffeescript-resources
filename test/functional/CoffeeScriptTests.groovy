
class CoffeeScriptTests extends functionaltestplugin.FunctionalTestCase {

	void testBundle() {
		get('http://localhost:8080/coffeescript-resources/static/bundle-bundle_coffee_defer.js')

		assertStatus 200
		assertContent """(function() {
		  var a;
		  a = 1;
		}).call(this);
		"""
	}
}