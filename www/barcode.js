cordova.define("com.equipnet.plugin.barcode.Barcode", function(require, exports, module) { /** 
 * 
 * @return Instance of Barcode 
 */ 
var Barcode = function() {} 

Barcode.prototype.read = function( successCallback, failureCallback ) { 
    return cordova.exec(successCallback,failureCallback,'Barcode','read'); 
}; 

if(!window.plugins) { 
    window.plugins = {}; 
} 
if (!window.plugins.Barcode) { 
    window.plugins.Barcode = new Barcode(); 
}

});
