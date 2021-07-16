import React,{useState} from 'react';
import validate from './validate';
const useForm = (initialValues) => {
    const [policy,setPolicy] = useState(initialValues);
    const [errors,setErrors] = useState(initialValues);
    const handleSubmit = (event) => {
        event.preventDefault();
        const validationErrors = validate(policy);
        const noErrors = Object.keys(validationErrors).length === 0;
        setErrors(validationErrors);
        if(noErrors){
          console.log("Authenticated",policy);
        }else{
          console.log("errors try again",validationErrors);
        }
    }
    const handleInputChange = (event) => {
      event.persist();
      setPolicy(policy => ({...policy, [event.target.name]: event.target.value}));
      }
    return {
      handleSubmit,
     handleInputChange,
     policy
      };
}
export default useForm;