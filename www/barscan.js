cordova.define("com.equipnet.tools.barcode", function(require, exports, module) {

var cordova = require('cordova');

var barcode = {
	getScannedCode : function(successCallback, errorCallback){
	cordova.exec(successCallback, errorCallback,'Barscan', 'getScannedCode', []);// Barscan->stringa che identifica 											      //l'oggetto e il rispettivo metodo richiamato
} 											//[] e relativi eventuali parametri
};

module.exports = barcode;

});
