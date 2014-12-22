var exec = require('cordova/exec');

exports.turn_up = function(arg0, success, error) {
    exec(success, error, "skypeakerphone", "turn_up", []);
};

exports.turn_down = function(arg0, success, error) {
    exec(success, error, "skypeakerphone", "turn_down", []);
};
