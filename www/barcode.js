var cordova = require('cordova');

var barcode = {
	read : function(successCallback, errorCallback){
	cordova.exec(successCallback, errorCallback,'Barcode', 'read', []);//ImeiPlugin ->stringa che identifica 											      //l'oggetto e il rispettivo metodo richiamato
} 											//[] e relativi eventuali parametri
};

module.exports = barcode;
