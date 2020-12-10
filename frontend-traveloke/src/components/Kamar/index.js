import React from "react";
import classes from "./styles.module.css";

const Kamar = (props) => {
const { namaKamar, kapasitasKamar } = props;
return (
    <div className={classes.kamar}>
        {`${namaKamar}`} {`(${kapasitasKamar})`}
    </div>
    );
};
export default Kamar;
