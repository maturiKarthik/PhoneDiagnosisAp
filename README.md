# PhoneDiagnosisAp
Commit Without comments

Pls remove the Ap while clonnig


       MyTask myTask = new MyTask();
        myTask.execute("Sleeping"); //CODE TO CALL THE ASYNTASK

  public class MyTask extends AsyncTask<String,String,String> {



        @Override
        protected void onPreExecute() {

           // PrE EXECUTE CODE ..

        }

        @Override
        protected String doInBackground(String... strings) {
         // Code to be EXecuted IN BC ..

            return null;
        }



        @Override
        protected void onPostExecute(String s) {
           //CODE TO UPDATE THE UI
        }
    }
