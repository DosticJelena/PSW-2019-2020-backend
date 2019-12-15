import React from 'react';
import './App.css';
import {BrowserRouter } from 'react-router-dom'
import {Switch, Route} from 'react-router'
import Register from './LoginAndRegistration/Register/Register'
import Login from './LoginAndRegistration/Login/Login'
import Nurse from './Content/Nurse/Nurse'
import Doctor from './Content/Doctor/Doctor'
import PatientsList from './Content/PatientsList/PatientsList'
import AbsenceRequest from './Content/Doctor/AbsenceRequest/AbsenceRequest';
import NewAppointmentDoctor from './Content/Doctor/NewAppointmentDoctor/NewAppointmentDoctor';
import PersonalProfile from './Content/PersonalProfile/PersonalProfile';
import WorkCalendar from './Content/WorkCalendar/WorkCalendar';
import Patient from './Content/Patient/Patient';
import ClinicsList from './Content/ClinicsList/ClinicsList';
import AppointmentHistory from './Content/MedicalRecord/AppointmentHistory/AppointmentHistory';
import MedicalRecord from './Content/MedicalRecord/MedicalRecord';
import CCAdmin from './Content/CCAdmin/CCAdmin';
import ClinicAdmin from './Content/ClinicAdmin/ClinicAdmin';
import QuickReservation from './Content/ClinicAdmin/QuickReservation/QuickReservation';
import EditPersonalProfile from './Content/PersonalProfile/EditPersonalProfile';
import NonCCAdmins from './Content/CCAdmin/Tables/NonCCAdmins'
import ChangePassword from './LoginAndRegistration/ChangePassword/ChangePassword';
import ClinicPage from './Content/Clinic/ClinicPage'
import PredefinedExaminations from './Content/Clinic/PredefinedExaminations/PredefinedExaminations'
import Drug from './Content/Codebook/Drug/Drug';
import Diagnosis from './Content/Codebook/Diagnosis/Diagnosis';
import RegistrationRequests from './Content/ClinicAdmin/RegistrationRequests/RegistrationRequests';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Switch>
        <Route exact path="/">
            <Login />
          </Route>
          <Route path="/login">
            <Login />
          </Route>
          <Route path="/register">
            <Register />
          </Route>
          <Route path="/my-profile">
            <PersonalProfile />
          </Route>
          <Route path="/nurse">
            <Nurse />
          </Route>
          <Route path="/doctor">
            <Doctor />
          </Route>
          <Route path="/patients">
            <PatientsList />
          </Route>
          <Route path="/absence-request">
            <AbsenceRequest />
          </Route>
          <Route path="/new-appointment-doctor">
            <NewAppointmentDoctor />
          </Route>
          <Route path="/work-calendar">
            <WorkCalendar />
          </Route>
          <Route path="/patient">
            <Patient />
          </Route>
          <Route path="/clinics">
            <ClinicsList />
          </Route>
          <Route path="/appointment-history">
            <AppointmentHistory />
          </Route>
          <Route path="/medical-record">
            <MedicalRecord />
          </Route>
          <Route path="/ccadmin">
            <CCAdmin />
          </Route>
          <Route path="/clinic-admin">
            <ClinicAdmin />
          </Route>
          <Route path="/quick-reservation">
            <QuickReservation />
          </Route>
          <Route path="/edit-personal-page">
            <EditPersonalProfile />
          </Route>
          <Route path="/assign-ccadmin">
            <NonCCAdmins />
          </Route>
          <Route path="/change-password">
            <ChangePassword />
          </Route>
          <Route path="/clinic-page">
            <ClinicPage />
          </Route>
          <Route path="/predefined-examinations">
            <PredefinedExaminations />
          </Route>
          <Route path="/drugs">
            <Drug />
          </Route>
          <Route path="/diagnosis">
            <Diagnosis />
          </Route>
          <Route path="/registration-requests">
            <RegistrationRequests/>
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;