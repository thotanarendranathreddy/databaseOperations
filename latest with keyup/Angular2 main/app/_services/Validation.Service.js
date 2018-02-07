"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var ValidationService = (function () {
    function ValidationService() {
    }
    ValidationService.getValidatorErrorMessage = function (validatorName, validatorValue) {
        var config = {
            'required': 'Required',
            'invalidNumber': 'Invalid Input!!!'
        };
        return config[validatorName];
    };
    ValidationService.inputNumberValidator = function (control) {
        // RFC 2822 compliant regex
        if (control.value.match(/^[0-9]{0,4}$/)) {
            return null;
        }
        else {
            return { 'invalidNumber': true };
        }
    };
    return ValidationService;
}());
exports.ValidationService = ValidationService;
//# sourceMappingURL=Validation.Service.js.map