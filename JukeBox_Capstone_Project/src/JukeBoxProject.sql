create database jukebox;
use jukebox;

create table User
(
 User_id int primary key,
 User_password varchar(20) not null,
 User_MobileNo long not null
 );
 
 create table Playlist
 (
 User_id int not null,
 Playlist_id int not null,
 Playlist_name varchar(20),
 primary key(playlist_id),
 foreign key(User_id) references User(User_id) on update cascade on delete cascade
 );
 
 create table PlaylistDetails
 (
 Playlist_id int not null,
 S_id varchar(20) not null,
 P_id varchar(20) not null,
 foreign key(Playlist_id) references Playlist(Playlist_id) on update cascade on delete cascade,
 foreign key(S_id) references Song(S_id) on update cascade on delete cascade,
 foreign key(P_id) references Podcast(P_id) on update cascade on delete cascade
 );
 
 create table Song
 (
 S_id varchar(20) primary key,
 S_name varchar(20),
 S_genre varchar(30),
 S_artist varchar(30),
 S_duration int not null,
 S_Filepath varchar(50),
 Playlist_id int not null,
 foreign key(Playlist_id) references Playlist(Playlist_id) on update cascade on delete cascade
);
alter table song modify S_duration time;

delete from song where S_id='sid02'and Playlist_id=1234;

create table Podcast
(
P_id varchar(20) primary key, 
P_genre varchar(30),
P_artist varchar(30),
P_episode varchar(20),
P_releasedate int not null,
P_Filepath varchar(50),
Playlist_id int not null,
foreign key(Playlist_id) references Playlist(Playlist_id) on update cascade on delete cascade
);

delete from user where user_id=143;
alter table podcast modify P_releasedate date;
DELETE FROM Playlist WHERE Playlist_id=799;
delete from Song where Playlist_id=456;
update podcast set playlist_id=111 where p_id='Pid103';


select * from User;
select * from Playlist;
select * from PlaylistDetails;
select * from Song; 
select * from Podcast;

alter table podcast modify P_filepath varchar(200);


desc song;
desc podcast;

alter table song modify S_FilePath varchar(100);
update song set S_FilePath='C:\\NIIT\\Course 3\\JukeBox_Capstone_Project\\src\\Song4.wav' where S_Id='S_61';
update podcast set P_Filepath='C:\\NIIT\\Course 3\\JukeBox_Capstone_Project\\src\\Podcast1.wav' where P_id='Pid58';

