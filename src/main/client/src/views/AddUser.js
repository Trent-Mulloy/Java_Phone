import axios from "axios";
import React, { useState } from "react";


export default function AddUser() {

  const [user, setUser] = useState({
    userName: (""),
    email: (""),
    password: (""),
    confirm: ("")
  });

  const { userName, email, password, confirm } = user;

  const onInputChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const onRegister = async (e) => {
    e.preventDefault();
    await axios.post("http://localhost:8080/register", user);
  };

  // const onLogin = (e) => {
  //   e.preventDefault();
  //   axios.get(`http://localhost:8080/user/${email}`)
  //   .then((response) => {
  //       const oneUser = response.data;
  //       setUser(oneUser);
  //       console.log (response.data);
  //       console.log(user);
  //   })
  // };

  return (
    <div className="container">
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">Register User</h2>
            {/* Register User */}
          <form onSubmit={(e) => onRegister(e)}>
            <div className="mb-3">
              <label htmlFor="userName" className="form-label">
                UserName
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your userName"
                name="userName"
                value={userName}
                  onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Username" className="form-label">
                Email
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="email"
                name="email"
                value={email}
                 onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Password" className="form-label">
                password
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your password"
                name="password"
                value={password}
                 onChange={(e) => onInputChange(e)}
              />
            </div>
            <div className="mb-3">
              <label htmlFor="Confirm" className="form-label">
                password
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Confirm"
                name="confirm"
                value={confirm}
                 onChange={(e) => onInputChange(e)}
              />
            </div>
            <button type="submit" className="btn btn-outline-primary">
              Register
            </button>
          </form>
        </div>
      </div>
      </div>
);
  }

