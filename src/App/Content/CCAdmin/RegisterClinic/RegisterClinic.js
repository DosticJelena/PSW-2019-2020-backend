import React from 'react';
import { Button} from 'react-bootstrap';
import axios from 'axios';
import Header from '../../Header/Header';
import './RegisterClinic.css'
import {NotificationManager} from 'react-notifications';

const capitalLetterRegex = RegExp(
    /^([A-Z][a-z]+)+$/
);

const formValid = ({ formErrors, ...rest }) => {
    let valid = true;
  
    // validate form errors being empty
    Object.values(formErrors).forEach(val => {
      val.length > 0 && (valid = false);
    });
  
    // validate the form was filled out
    Object.values(rest).forEach(val => {
      val === null && (valid = false);
    });
  
    return valid;
  };


class RegisterClinic extends React.Component {

  constructor(props){
      super(props);

      this.handleChange = this.handleChange.bind(this);
      this.SendRegisterRequest = this.SendRegisterRequest.bind(this);

      this.state = {
            name: null,
            description: null,
            address: null,
            city: null,
            formErrors: {
                name: "",
                description: "",
                address: "",
                city: "",
              }
      }
   }

  SendRegisterRequest = event => {

      event.preventDefault();
      console.log(this.state);
      if (formValid(this.state)) {
          axios.post("http://localhost:8080/api/cc-admin/register-clinic", {
            name: this.state.name,
            description: this.state.description,
            address: this.state.address,
            city: this.state.city

        }).then((resp) => {NotificationManager.success('Clinic has been successfully added.', '', 3000);}) 
        .catch((error)=> {NotificationManager.error('System error. Please try again later.', 'Error', 3000);})
      }
      else {
        NotificationManager.error('Wrong form input. Please input the correct strings.', '', 3000);
      } 
  }

  handleChange = e => {
    e.preventDefault();
    const { name, value } = e.target;
    let formErrors = { ...this.state.formErrors };

    switch (name) {
      case "name":
        formErrors.name = capitalLetterRegex.test(value)
          ? ""
          : "name must start with a capital letter";

        if (formErrors.name === ""){  
            formErrors.name =
            value.length < 3 ? "minimum 3 characaters required" : "";
        }
        break;
      case "description":
            formErrors.description =
            value.length < 3 ? "minimum 6 characaters required" : "";
        break;
      case "address":
        formErrors.address = capitalLetterRegex.test(value)
          ? ""
          : "Address must start with a capital letter";

        if (formErrors.address === ""){  
            formErrors.address =
            value.length < 3 ? "minimum 3 characaters required" : "";
        }
        break;
      case "city":
        formErrors.city = capitalLetterRegex.test(value)
        ? ""
        : "City must start with a capital letter";

      if (formErrors.city === ""){  
          formErrors.city =
          value.length < 3 ? "minimum 3 characaters required" : "";
      }
        break;
      default:
        break;
    }
    this.setState({ formErrors, [name]: value}, () => console.log(this.state));
  }

  render() {
      const { formErrors } = this.state;
      return (
        <div className="RegisterNewCCAdmin">
        <Header/>
            <div className="row register-form">
                <div className="col-md-6">
                <form onSubmit={this.SendRegisterRequest} noValidate>
            <div className="name">
              <label htmlFor="name">Name: </label>
              <input
                className={formErrors.name.length > 0 ? "error" : null}
                placeholder="Name"
                type="text"
                name="name"
                noValidate
                onChange={this.handleChange}
              />
              {formErrors.name.length > 0 && (
                <span className="errorMessage">{formErrors.name}</span>
              )}
            </div>
            <div className="description">
              <label htmlFor="description">Description: </label>
              <input
                className={formErrors.description.length > 0 ? "error" : null}
                placeholder="Description"
                type="text"
                name="description"
                noValidate
                onChange={this.handleChange}
              />
              {formErrors.description.length > 0 && (
                <span className="errorMessage">{formErrors.description}</span>
              )}
            </div>
            <div className="address">
              <label htmlFor="address">Address: </label>
              <input
                className={formErrors.address.length > 0 ? "error" : null}
                placeholder="Address"
                type="address"
                name="address"
                noValidate
                onChange={this.handleChange}
              />
              {formErrors.address.length > 0 && (
                <span className="errorMessage">{formErrors.address}</span>
              )}
            </div>
            <div className="city">
              <label htmlFor="city">City: </label>
              <input
                className={formErrors.city.length > 0 ? "error" : null}
                placeholder="City"
                type="city"
                name="city"
                noValidate
                onChange={this.handleChange}
              />
              {formErrors.city.length > 0 && (
                <span className="errorMessage">{formErrors.city}</span>
              )}
            </div>
                            <hr/>
                            <Button className="createAccount" type="submit">Create</Button>
                        </form>
                </div>
            </div>
      </div>
  );
}
}

export default RegisterClinic;