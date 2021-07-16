const validate = (policy) => {
   
   const errors = {};
   if (!policy.policyName) {
       errors.policyName = 'Check PolicyName';
   } 
   if (!policy.policyDescription) {
    errors.policyDescription = 'Check Policy Description';
} 
   return errors;
 }
 export default validate;