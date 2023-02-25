import axios from "axios";

const TEST_API_URL = "http://localhost:8080/hello/world";

//   "http://localhost:8080/api/free/currentTop5HashtagDtoList";
class DeliveryService {
  getHello() {
    return axios.get(TEST_API_URL);
  }
  getWayPoint() {
    try {
      return axios.get("http://localhost:8080/api/waypoint/getWaypoint");
    } catch (error) {
      console.log(error);
    }
  }
  getWayPointList() {
    try {
      return axios.get("http://localhost:8080/api/driverApp/convertToQueue");
    } catch (error) {
      console.log(error);
    }
  }
  async updateWayPointList(listInput) {
    try {
      return await axios.post(
        "http://localhost:8080/api/driverApp/updateQueue", listInput
      );
    } catch (error) {
      console.log(error);
    }
  }
}

//Export object of class
export default new DeliveryService();
