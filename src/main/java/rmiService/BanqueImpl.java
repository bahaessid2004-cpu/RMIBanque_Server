package rmiService;
import metier.Compte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
public class BanqueImpl extends UnicastRemoteObject implements IBanque{

        private HashMap<Integer, Compte> comptes;

        public BanqueImpl() throws RemoteException {
            super();
            comptes = new HashMap<>();
        }

        @Override
        public String creerCompte(Compte c)
                throws RemoteException {

            if (comptes.containsKey(c.getCode())) {
                return "Compte existe déjà";
            }

            comptes.put(c.getCode(), c);

            return "Compte créé avec succès";
        }

        @Override
        public String getInfoCompte(int code)
                throws RemoteException {

            Compte c = comptes.get(code);

            if (c == null) {
                return "Compte introuvable";
            }

            return c.toString();
        }
    }


