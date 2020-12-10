import React from "react";
import classes from "./styles.module.css";
import Button from "../Button";
import Kamar from "../Kamar";

const Hotel = (props) => {
const { id, namaHotel, alamat, nomorTelepon, listKamar, handleEdit, handleDelete} = props;
return (
    <div className={classes.hotel}>
        <h3>{`ID Hotel ${id}`}</h3>
        <p>{`Nama Hotel: ${namaHotel}`}</p>
        <p>{`Alamat: ${alamat}`}</p>
        <p>{`Nomor telepon: ${nomorTelepon}`}</p>
        {listKamar.map((kamar) => (
            <Kamar
                namaKamar={kamar.namaKamar}
                kapasitasKamar={kamar.kapasitasKamar}
            >
            </Kamar>
        ))}
        <div>
            <Button onClick={handleEdit} variant="success">
                Edit
            </Button>
            <Button onClick={handleDelete} variant="danger">
                Delete
            </Button>
        </div>
    </div>
    );
};
export default Hotel;
