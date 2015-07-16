module.exports = {
  gpspos: function(success, error) {
    cordova.exec(success, error, 'Gps', 'gpspos', []);
  }
};
