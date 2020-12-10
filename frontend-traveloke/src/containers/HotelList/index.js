import React, {Component} from "react";
import Hotel from "../../components/Hotel";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";

class HotelList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            hotels: [],
            isLoading: false,
        };
        // this.handleClickLoading = this.handleClickLoading.bind(this);
    }

    // handleClickLoading() {
    //     const currentLoading = this.state.isLoading;
    //     this.setState({ isLoading: !currentLoading });
    //     console.log(this.state.isLoading);
    // }

    componentDidMount() {
        this.loadData()
        // console.log("componentDidMount()");
    }

    async loadData() {
    try {
        const { data } = await APIConfig.get("/hotels");
        this.setState({ hotels: data });
    } catch (error) {
        alert("Oops terjadi masalah pada server");
        console.log(error);
    }
}

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    render() {
        console.log("render()");
        return (
            <div className={classes.hotelList}>
                <h1 className={classes.title}>All Hotels</h1>
                <div>
                    {this.state.hotels.map((hotel) => (
                    <Hotel
                    key={hotel.id}
                    id={hotel.id}
                    namaHotel={hotel.namaHotel}
                    alamat={hotel.alamat}
                    nomorTelepon={hotel.nomorTelepon}
                    />
                    ))}
                </div>
            </div>
        );
    }
}

export default HotelList;