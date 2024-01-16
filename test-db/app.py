from flask import Flask, jsonify
import mysql.connector
import flask_cors

app = Flask(__name__)

flask_cors.CORS(app)
# Replace these with your MySQL database credentials
DB_HOST = 'mysql'
DB_USER = 'root'
DB_PASSWORD = 'my-secret-pw'
DB_NAME = 'mydb'

def test_mysql_connection():
    try:
        # Establish a connection to the MySQL database
        connection = mysql.connector.connect(
            host=DB_HOST,
            user=DB_USER,
            password=DB_PASSWORD,
            database=DB_NAME
        )
        
        # Check if the connection is successful
        if connection.is_connected():
            return True
        else:
            return False
    except Exception as e:
        print(f"Error: {e}")
        return False
    finally:
        # Close the connection in any case
        if 'connection' in locals() and connection.is_connected():
            connection.close()

@app.route('/')
def test_connection():
    # Test the MySQL connection
    if test_mysql_connection():
        return jsonify({"message": "MySQL connection successful"})
    else:
        return jsonify({"message": "MySQL connection failed"})
    

@app.route('/hello')
def hello():
    return jsonify({"message": "Hello World!"})
if __name__ == '__main__':
    app.run(debug=True,port=5000)
