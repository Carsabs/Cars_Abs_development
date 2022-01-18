create table pre_upload_annrt 
  (
    mcn char(9),
    action_code char(1),
    change_date date,
    user_name char(8)
  );
INSERT INTO PRE_UPLOAD_ANNRT VALUES ('002021', 'A', sysdate(),'chandu');    
INSERT INTO PRE_UPLOAD_ANNRT VALUES ('002022', 'A', sysdate(),'sai');    