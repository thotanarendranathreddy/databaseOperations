export class ValidationService {
    static getValidatorErrorMessage(validatorName: string, validatorValue?: any) {
        let config = {
            'required': 'Required' ,
            'invalidNumber':'Invalid Input!!!'
            };

        return config[validatorName];
    }
    
    static inputNumberValidator(control:any) {
        // RFC 2822 compliant regex
        if (control.value.match(/^[0-9]{0,4}$/)) {
            return null;
        } else {
            return { 'invalidNumber': true };
        }
    }
    
    
}