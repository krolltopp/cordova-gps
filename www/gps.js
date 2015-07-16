module.exports = {
  pos: function(success, error) {
    cordova.exec(success, error, 'Gps', 'gpspos', []);
  }
};
