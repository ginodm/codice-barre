cordova.define("com.equipnet.tools.barcode", function(require, exports, module) {

var cordova = require('cordova');

var barcode = {
	getImeiNumber : function(successCallback, errorCallback){
	cordova.exec(successCallback, errorCallback,'Barscan', 'getScannedCode', []);//ImeiPlugin ->stringa che identifica 											      //l'oggetto e il rispettivo metodo richiamato
} 											//[] e relativi eventuali parametri
};

module.exports = barcode;

});
