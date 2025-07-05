import pandas as pd
from flask import Flask, request, jsonify
from joblib import load 

app = Flask(__name__)

try:
    model_disease = load('svm_disease_model.joblib')
    model_department = load('svm_department_model.joblib')
    label_encoder_disease = load('label_encoder_disease.joblib')
    label_encoder_department = load('label_encoder_department.joblib')
except Exception as e:
    print(f"Prediction error: {e}")
SYMPTOM_COLUMNS = ['fever', 'headache', 'nausea', 'vomiting', 'fatigue','joint_pain', 'skin_rash', 'cough', 'weight_loss', 'yellow_eyes']

@app.route('/predict', methods=['POST'])
def predict(boolean[] arr):
    try:
        data = request.get_json(force=True)
        symptoms_input = data.get('symptoms', {}) 

        input_data = {symptom: symptoms_input.get(symptom, 0) for symptom in SYMPTOM_COLUMNS}
        input_df = pd.DataFrame([input_data])

        disease_prediction_encoded = model_disease.predict(input_df)
        department_prediction_encoded = model_department.predict(input_df)

        predicted_disease = label_encoder_disease.inverse_transform(disease_prediction_encoded)[0]
        predicted_department = label_encoder_department.inverse_transform(department_prediction_encoded)[0]

        return jsonify({
            'disease': predicted_disease,
            'department': predicted_department
        })

    except Exception as e:
        print(f"Prediction error: {e}")
        return jsonify({'error': str(e), 'message': 'An error occurred during prediction. Please check your input.'}), 500

if __name__ == '__main__':
    app.run(debug=false, host='127.0.0.1', port=5000)

