import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import TableSubject from './TableSubject';
const SubjectManagementPage = ({ currentUser }) => {
  const navigate = useNavigate();

  useEffect(() => {
    if (!currentUser) {
      navigate('/');
    }
    console.log('check cu', currentUser);
  }, [currentUser, navigate]);

  return (
    <div>
      {currentUser && (
        <div className="container" style={{ marginTop: 80,zIndex:20  }}>
          <div className="card bg-light text-black p-4">
            <h3 className="">Quản lý Lớp Học Phần</h3>
            <hr></hr>
            <TableSubject currentUser={currentUser} ></TableSubject>
          </div>
        </div>
      )}
    </div>
  );
};

export default SubjectManagementPage;
