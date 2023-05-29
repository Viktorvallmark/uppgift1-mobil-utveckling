# uppgift1-mobil-utveckling

Skapade en eventlistener på accelerometern som lyssnade när sensorn registrerade en förändring. Skapade sedan en instans av en sensorManager som kollade efter om telefonen har en accelerometer så att man kan ta data från den.
Om den inte har det så kommer felmeddelandet "No accelerometer in the device!" att loggas. Om den har en accelerometer kommer värdena från accelerometern att visas på skärmen med hjälp av textView-objekten. Värdena uppdateras genom 
onSensorChanged()-funktionen som sedan uppdaterar arrayen values som man sedan tar respektive x-värde, y-värde och z-värde ifrån.
När appen inte är i fokus, utan är i bakgrunden, så kommer sensorManagern att hantera detta genom att avregistrera listenern så att appen inte tar upp minne och batteritid. Denna funktion finns implementerad i funktionen onPause(). 
När appen är i fokus så hanterar sensorManagern detta genom att registrera listenern igen.
Om man vill stoppa appen så hanteras detta i onStop() funktionen där sensorManagern avregistrerar listenern och man stänger appen med super.onStop().
Det som var klurigast att lista ut var hur man skulle hantera alla klasser som man inte riktigt vet vilka metoder de har eller vilka member-variables som är till någon nytta. Efter lite googling så insåg man att sensorEvent och sensorManager var
vägen framåt.
